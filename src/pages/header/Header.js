
import Navbar from "react-bootstrap/Navbar";
import Container from "react-bootstrap/Container";
import Nav from "react-bootstrap/Nav";
import {Link} from "react-router-dom";
import "./Header.css";
const Header = () => {
    return(
        <>
            <Navbar bg="primary" variant="dark">
                <Container>
                <Navbar.Brand to="/"><strong>달빛마루</strong></Navbar.Brand>
                    <Nav className="ml-auto">
                        <Nav.Link as={Link} to="/" className="nav-link">【プレイリスト】</Nav.Link>
                        <Nav.Link as={Link} to="/musicList" className="nav-link">【申請ページへ】</Nav.Link>
                    </Nav>
                </Container>
            </Navbar>
        </>
    )
}

export default Header;