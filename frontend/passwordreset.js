import React, {useState} from 'react';
import ReactDOM from 'react-dom';

import Button from '@mui/material/Button';

import Typography from '@mui/material/Typography';
import Link from '@mui/material/Link';
import Avatar from '@mui/material/Avatar';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';


export default function Passwordreset() {
    
	const [password , setPassword] = useState('');
	const [confPassword , setConfPassword] = useState('');

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
		alert("password Not Match");
	}
	else{
		// display alert box with user
		// 'name' and 'email' details .
		alert('password changed successfully');
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
       <Grid item xs={12} sm={8} md={5}>
          <Box
            sx={{
              my: 3,
              mx: 4,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}
          >
            <Avatar
  alt="Remy Sharp"
  src="https://i.pinimg.com/originals/74/38/54/7438544220bc7e1456019ed2183e18d2.jpg"
  sx={{ width: 60, height: 60}} /> </Box></Grid>

	<Typography component="h2" variant="h3" color="white"><b>
              Reset Password </b>
            </Typography>
            
    
            
  
		<label>
		<Typography variant="h6" color="white" mb={2}><b>
        New Password: </b>
            </Typography>
		</label>
		<input type="password" value={password} required onChange={(e)=> {handlePasswordChange(e)}} /><br/>
			{/* when user write in password input box ,
				handlePasswordChange() function will be called.*/}
		<label>
		<Typography variant="h6" color="white" mb={2} mt={2}><b>
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
                Update Password
              </Button>
	</form>
    <Grid container>
                <Grid item xs>
                  <Link href="/login" variant="body2">
                    Go Back to login
                  </Link>
                </Grid>
                </Grid>
	</header>
	</div>
);

}

