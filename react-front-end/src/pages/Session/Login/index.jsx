import React, {Component} from "react";
import {styleSheet} from "./style";
import {withStyles} from "@material-ui/core";
import Typography from "@mui/material/Typography";

class Login extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        const {classes} = this.props;
        return (
            <div className={classes.container}>
                <div className={classes.login_cover}>
                    <div className={classes.title_container}>
                        <Typography variant="h5" gutterBottom component="div">
                            Login Here
                        </Typography>
                    </div>
                    <div className={classes.form_container}></div>
                    <div className={classes.button_container}></div>
                </div>
            </div>
        );
    }
}

export default withStyles(styleSheet)(Login)
