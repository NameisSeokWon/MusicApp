import './App.css';
import Header from "./pages/header/Header";
import {Route, Routes} from "react-router-dom";
import Dashboard from "./pages/dashboard/Dashboard";
import NoMatch from "./pages/noMatch/NoMatch";
import PostSong from "./pages/musicList/PostSong";
import UpdateSong from "./pages/musicList/UpdateSong";

function App() {
  return (
     <>
      <Header/>
         <Routes>
             <Route path='/' element={<PostSong/>}/>
             <Route path='/musicList' element={<Dashboard/>}/>
             <Route path='/musicList/:id' element={<UpdateSong/>}/>
             <Route path='*' element={<NoMatch/>}/>
         </Routes>
     </>
  );
}

export default App;
