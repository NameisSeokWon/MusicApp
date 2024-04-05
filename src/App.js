import './App.css';
import Header from "./pages/header/Header";
import {Route, Routes} from "react-router-dom";
import Dashboard from "./pages/dashboard/Dashboard";
import NoMatch from "./pages/noMatch/NoMatch";
import PostSong from "./pages/musicList/PostSong";

function App() {
  return (
     <>
      <Header/>
         <Routes>
             <Route path='/' element={<Dashboard/>}/>
             <Route path='/musicList' element={<PostSong/>}/>
             <Route path='*' element={<NoMatch/>}/>
         </Routes>
     </>
  );
}

export default App;
