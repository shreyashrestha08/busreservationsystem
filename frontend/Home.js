import * as React from 'react';
import { styled } from '@mui/material/styles';
import AppBar from '@mui/material/AppBar';
import Box from '@mui/material/Box';
import Toolbar from '@mui/material/Toolbar';
import IconButton from '@mui/material/IconButton';
import { Button } from '@mui/material';
import Typography from '@mui/material/Typography';
import MenuIcon from '@mui/icons-material/Menu';
import SearchIcon from '@mui/icons-material/Search';
import MoreIcon from '@mui/icons-material/MoreVert';
import Menu from '@mui/material/Menu';
import MenuItem from '@mui/material/MenuItem';
import Searchbus from './Searchbus';
import {useNavigate} from "react-router-dom";

import "../App.css";
import "../one.css"

const StyledToolbar = styled(Toolbar)(({ theme }) => ({
  alignItems: 'flex-start',
  paddingTop: theme.spacing(1),
  paddingBottom: theme.spacing(2),
  // Override media queries injected by theme.mixins.toolbar
  '@media all': {
    minHeight: 128,
  },
  

}));

export default function Home() {
  const navigate = useNavigate();
  const [anchorEl, setAnchorEl] = React.useState(null);
  const open = Boolean(anchorEl);
  const handleClick = (event) => {
    setAnchorEl(event.currentTarget);
  };
  const handleClose = () => {
    setAnchorEl(null);
  };

  
  return (
    <div className='One.header'>
    <Box sx={{ flexGrow: 1 
    }}>
      <AppBar position="static"
      
      
       sx={{  width: 1270, height: 300,
        backgroundImage: 'url(https://th.bing.com/th/id/OIP.dIsfS9uevnLcku_5HjWFGAHaEo?w=251&h=180&c=7&r=0&o=5&dpr=1.5&pid=1.7)',
        backgroundColor: (t) =>
        t.palette.mode === 'dark' ? t.palette.secondary[50] : t.palette.secondary[900],
      backgroundSize: 'contain',
      backgroundPosition: 'top',
      backdropFilter: "blur(2px)"
          }}
          >
        <StyledToolbar>
          
          
          
          <Typography variant="h3" color="white" align="center center"
            noWrap
            component="div"
            boxShadow={10}
            
            style={{
              marginLeft: "30%",}}
            sx={{ flexGrow: 1, alignSelf: 'baseline',
         }}
          ><b>
            AdiBus</b>
          </Typography>
          <Button variant="outlined" size="medium" color="inherit"
         style={{
          marginTop: "0.5%",
        marginRight: "2%"}}
          onClick={() => 
            navigate("/login")}
        >
        Login / SignUp    
          </Button>
          <IconButton size="small" aria-label="search" color="inherit"
          style={{
            marginTop: "0.5%",}} >
            <SearchIcon />
          </IconButton>

          <IconButton
            size="small"
            aria-label="display more actions"
            edge="end"
            color="inherit"
          >
            <Button
        id="demo-positioned-button"
        aria-controls={open ? 'demo-positioned-menu' : undefined}
        aria-haspopup="true"
        aria-expanded={open ? 'true' : undefined}
        
         onClick={handleClick}
        color="inherit"
        size="small"
        style={{
          marginTop: "1%",}}
        
      >
        <MoreIcon/>
      </Button>
      <Menu
        id="demo-positioned-menu"
        aria-labelledby="demo-positioned-button"
        anchorEl={anchorEl}
        open={open}
        onClose={handleClose}
      >
        <MenuItem onClick={() => 
            navigate("/searchroutes")}>Find Routes</MenuItem>
        <MenuItem onClick={() => 
            navigate("/offers")}>Offers</MenuItem>
        <MenuItem onClick={() => 
          navigate("/profile")}>Profile</MenuItem>
      </Menu>
            
          </IconButton>
        </StyledToolbar>
      </AppBar>
    </Box>
    <Searchbus/>
    </div>
  );
}
