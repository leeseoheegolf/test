import React from "react";
import { IoPersonSharp } from "react-icons/io5";
import { FaRegHeart } from "react-icons/fa";
import { Link, useNavigate } from "react-router-dom";
import { useSelector } from "react-redux";

export default function Navbar() {
    const user = useSelector((state) => state.user.userState);
    const navigate = useNavigate();

    const handlerMypage = () => {
        if (user === true) {
            navigate("/mypage");
        } else {
            alert("로그인 후 이용해주세요.");
            navigate("/login", {replace : true});
        }
    };

    return (
        <div className="navbar--container">
            <div className="navbar--wrap">
                <Link to="/wishlist" className="link">
                    <FaRegHeart className="icon" />
                </Link>

                <Link to="/" className="link">
                    <div className="home">LS</div>
                </Link>

                <IoPersonSharp className="icon" onClick={handlerMypage} />
            </div>
        </div>
    );
}
