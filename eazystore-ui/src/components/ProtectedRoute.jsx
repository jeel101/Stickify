import React, { useEffect } from "react";
import { Outlet, Navigate, useLocation } from "react-router-dom";
import { useSelector } from "react-redux";
import { selectIsAuthenticated } from "../store/auth-slice";

export default function ProtectedRoute() {
  const isAuthenticated = useSelector(selectIsAuthenticated);
  console.log("Auth:", isAuthenticated);
  const location = useLocation();

  useEffect(() => {
    const skipRedirectPath =
      sessionStorage.getItem("skipRedirectPath") === "true";
    if (
      !isAuthenticated &&
      location.pathname !== "/login" &&
      !skipRedirectPath
    ) {
      sessionStorage.setItem("redirectPath", location.pathname);
    }
  }, [isAuthenticated, location.pathname]);

  return isAuthenticated ? <Outlet /> : <Navigate to="/login" />;
}
