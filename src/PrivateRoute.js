import React from 'react';
import { Route, Navigate} from 'react-router-dom';

const PrivateRoute = ({ component: Component, ...rest }) => {
  // You can implement your authentication logic here
  const isAuthenticated = true /* Check if the user is authenticated */;

  return (
    <Route
      {...rest}
      render={(props) =>
        isAuthenticated ? (
          <Component {...props} />
        ) : (
          <Navigate to="/login" />
        )
      }
    />
  );
};

export default PrivateRoute;