import { Label, Rowing } from '@material-ui/icons';
import {TextField } from '@mui/material';
import React, {useState} from 'react';
import ReactDOM from 'react-dom';
import Box from '@mui/material/Box';
import Grid from '@mui/material/Grid';
import Paper from '@mui/material/Paper';

import '../App.css';
import Button from '@mui/material/Button';



export default function Searchbus() {
	const [From , setFrom] = useState('');
	const [To , setTo] = useState('');
	const [Date , setDate] = useState('');
	

	
	const handleChange =(e)=>{
	setFrom(e.target.value);
	}
	
	
	const handleToChange =(e)=>{
	setTo(e.target.value);
	}
	
	const handleDateChange =(e)=>{
	setDate(e.target.value);
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
        <Grid item xs={2} md={3}>
        <TextField
      
        margin="dense"
      name="date"
      color='error'
     id="date"
     fullWidth
     type="date"
      value={Date}
       required 
       onChange={(e)=> {handleDateChange(e)}}/>
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
              
</header>
	</div>
   

	
)
}

