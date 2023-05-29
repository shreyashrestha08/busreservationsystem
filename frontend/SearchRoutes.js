import { Label, Rowing } from '@material-ui/icons';
import {TextField } from '@mui/material';
import React, {useState} from 'react';
import ReactDOM from 'react-dom';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';
import Avatar from '@mui/material/Avatar';
import '../App.css';
import Button from '@mui/material/Button';
import Typography from '@mui/material/Typography';


import Link from '@mui/material/Link';

export default function SearchRoutes() {
	const [From , setFrom] = useState('');
	const [To , setTo] = useState('');
	
	

	
	const handleChange =(e)=>{
	setFrom(e.target.value);
	}
	
	
	const handleToChange =(e)=>{
	setTo(e.target.value);
	}
	


    const handleSubmit=(e)=>{
        if(From == To)
        {
            // if 'password' and 'confirm password'
            // does not match.
            alert(" Source and Destination cannot be same");
        }
        else{
            // display alert box with user
            // 'name' and 'email' details .
            alert('Searching');
        }
        e.preventDefault();
    
        }

	
return (
	<div >
        <header className='One.header'>
    <Box sx={{ mt: 4, ml:40 }}
     onSubmit={(e) => {handleSubmit(e)} } 
     alignContent="center">

<Grid item xs={12} sm={8} md={5} >
          <Box
            sx={{
              my: 4,
              mx: 4,
              mr: 55,
              display: 'flex',
              flexDirection: 'column',
              alignItems: 'center',
            }}
          >
            <Avatar
  alt="Remy Sharp"
  src="https://i.pinimg.com/originals/74/38/54/7438544220bc7e1456019ed2183e18d2.jpg"
  sx={{ width: 60, height: 60 }} />
            <Typography component="h1" variant="h8">
              Search Routes!
            </Typography></Box>
            </Grid>

      <Grid container spacing={2} component="form">
        <Grid item xs={2} md={3} >
        <TextField 
        name="From"
        label="From"
        id='From'
        margin="dense"
        fullWidth
        value={From} 
        required 
        onChange={(e)=> {handleChange(e)}}
     />
        </Grid>
        <Grid item xs={2} md={3}>
        <TextField
         margin="dense"
        name="To"
        color='error'
        label="To"
        fullWidth
       id="To"
        value={To}
         required 
         onChange={(e)=> {handleToChange(e)}}
        />
        </Grid>
    
    <Button
                type="submit"
                variant="contained"
                value="Submit"
                sx={{ mt: 4, ml: 2, mb:4}}
              >
                Search
              </Button>
              </Grid>
              </Box>
              <Grid container>
                <Grid item xs mr={10}>
                  <Link href="/home" variant="body2">
                    Book A Bus
                  </Link>
                </Grid>
                </Grid>
              
</header>
	</div>
   

	
)
}

