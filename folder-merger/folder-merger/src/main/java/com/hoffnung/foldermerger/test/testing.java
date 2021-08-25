package com.hoffnung.foldermerger.test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class testing {

	public static void main(String[] args) {
		String leftFolderPath = "E:\\Backups Photo";
		String rightFolderPath = "I:\\family";
		File leftFolder = new File(leftFolderPath);
		File rightFolder = new File(rightFolderPath);

		String[] leftDirectories = leftFolder.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});

		String[] rightDirectories = rightFolder.list(new FilenameFilter() {
			@Override
			public boolean accept(File current, String name) {
				return new File(current, name).isDirectory();
			}
		});
		System.out.println("Left : " + Arrays.toString(leftDirectories));
		System.out.println("Right : " + Arrays.toString(rightDirectories));

		List<String> left = Arrays.asList(leftDirectories);
		List<String> right = Arrays.asList(rightDirectories);
		List<String> leftToRight = new ArrayList<String>(left);
		leftToRight.removeAll(right);
		System.out.println("Left to Right : " + leftToRight);

		leftToRight.stream().forEach(i -> {
			try {
				copyFolder(Path.of(rightFolderPath + File.separator + i), Path.of(leftFolderPath + File.separator + i));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		System.out.println("******* Done +" + rightFolderPath + " TO " + leftFolderPath + "+ ******");

		List<String> rightToLeft = new ArrayList<String>(right);
		rightToLeft.removeAll(left);
		System.out.println("Right to Left :" + rightToLeft);
		rightToLeft.stream().forEach(i -> {
			try {
				copyFolder(Path.of(rightFolderPath + File.separator + i), Path.of(leftFolderPath + File.separator + i));
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		System.out.println("******* Done +" + rightFolderPath + " TO " + leftFolderPath + "+ ******");
	}

	public static void copyFolder(Path src, Path dest) throws IOException {
		try (Stream<Path> stream = Files.walk(src)) {
			stream.forEach(source -> copy(source, dest.resolve(src.relativize(source))));
		}
	}

	private static void copy(Path source, Path dest) {
		try {
			Files.copy(source, dest, StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Copyed " + source + " To " + dest);
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}

}
