import React, {useState} from 'react';
import ReactDOM from 'react-dom';

import Button from '@mui/material/Button';

import Typography from '@mui/material/Typography';

export default function SignUp() {
    
	const [name , setName] = useState('');
	const [email , setEmail] = useState('');
	const [password , setPassword] = useState('');
	const [confPassword , setConfPassword] = useState('');

	
	const handleChange =(e)=>{
	setName(e.target.value);
	}
	
	
	const handleEmailChange =(e)=>{
	setEmail(e.target.value);
	}
	
	const handlePasswordChange =(e)=>{
	setPassword(e.target.value);
	}
	// function to update state of confirm password
	// with value enter by user in form
	const handleConfPasswordChange =(e)=>{
	setConfPassword(e.target.value);
	}
	// below function will be called when user
	// click on submit button .
	const handleSubmit=(e)=>{
	if(password!=confPassword)
	{
		// if 'password' and 'confirm password'
		// does not match.
		alert("password Not Match");
	}
	else{
		// display alert box with user
		// 'name' and 'email' details .
		alert('A form was submitted with Name :"' + name +
		'" and Email :"' + email + '"');
	}
	e.preventDefault();

	}
return (
	<div className="App">
	<header className="App-header">
	<form onSubmit={(e) => {handleSubmit(e)}}
    >
	{/*when user submit the form , handleSubmit()
		function will be called .*/}
	<Typography component="h1" variant="h2" color="white"><b>
              AdiBus </b>
            </Typography>
            <Typography component="h2" variant="h5" color="white"> <b>
              JoinUs</b>
            </Typography>
    
	<img src="https://th.bing.com/th/id/OIP.dIsfS9uevnLcku_5HjWFGAHaEo?w=251&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7" />
		<br></br><label >
        <Typography variant="h6" color="white" ><b>
        Name: </b>
            </Typography>
		</label>
		<input type="text" value={name} required onChange={(e)=> {handleChange(e)}} /><br/>
		{ /*when user write in name input box , handleChange()
			function will be called. */}
		<label >
        <Typography variant="h6" color="white"><b>
        Email: </b>
            </Typography>
		</label>
		<input type="email" value={email} required onChange={(e)=> {handleEmailChange(e)}} /><br/>
		{}
		<label>
		<Typography variant="h6" color="white" ><b>
        Password: </b>
            </Typography>
		</label>
		<input type="password" value={password} required onChange={(e)=> {handlePasswordChange(e)}} /><br/>
			{/* when user write in password input box ,
				handlePasswordChange() function will be called.*/}
		<label>
		<Typography variant="h6" color="white" ><b>
        ConfirmPassword: </b>
            </Typography>
		</label>
		<input type="password" value={confPassword} required onChange={(e)=> {handleConfPasswordChange(e)}} /><br/>
				{/* when user write in confirm password input box ,
					handleConfPasswordChange() function will be called.*/}
		<Button
                type="submit"
                color='error'
                variant="contained"
                value="Submit"
                sx={{ mt: 3, mb: 2 }}
              >
                Submit
              </Button>
	</form>
	</header>
	</div>
);

}

