import React from 'react';
import logo from './logo.svg';
import './App.css';
import axios from 'axios';
import { useEffect, useState ,useCallback} from 'react';
import {useDropzone} from 'react-dropzone'


const UserProfiles =()=>{
  const [UserProfiles,setUserProfiles] = useState([]);
  const fetchUserProfile = ()=>{
    axios.get("http://localhost:8080/user-profile")
    .then(result=>{
      console.log(result);
      setUserProfiles(result.data);
    });
  };
useEffect(()=>{
  fetchUserProfile();
 
},[]);

return UserProfiles.map((userProfile,index)=>{
  return (
    <div key={index}>
      {userProfile.userProfileId ? (<img src={`http://localhost:8080/user-profile/${userProfile.userProfileId}/image/download`}></img>):null};
        <h1>{userProfile.username}</h1>
        <h1>{userProfile.userProfileId}</h1>
        <MyDropzone {...userProfile}></MyDropzone>
    </div>
  )
});
};

function MyDropzone({...userProfile}) {
  const onDrop = useCallback(acceptedFiles => {
    var file = acceptedFiles[0];
    console.log(file);
    debugger;
    const  fd = new FormData();
    fd.append("file",file);

    axios.post(`http://localhost:8080/user-profile/${userProfile.userProfileId}/image/upload`,fd,{headers:{"Content-Type":"multipart/form-data"}})
    .then(()=>{

    }).catch(er => console.log("error "+er));
    


    // Do something with the files
  }, [])
  const {getRootProps, getInputProps, isDragActive} = useDropzone({onDrop})

  return (
    <div {...getRootProps()}>
      <input {...getInputProps()} />
      {
        isDragActive ?
          <p>Drop the files here ...</p> :
          <p>Drag 'n' drop some files here, or click to select files</p>
      }
    </div>
  )
}

function App() {
  return (
    <div className="App">
     <UserProfiles></UserProfiles> 
    </div>
  );
}

export default App;
