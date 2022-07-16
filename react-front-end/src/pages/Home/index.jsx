import React, {Component} from "react";
import {withStyles} from "@material-ui/core";
import {styleSheet} from "./style";
import Typography from "@mui/material/Typography";

class HomePage extends Component {
    constructor(props) {
        super(props);
    }

    render() {
        const {classes} = this.props;
        return (
            <div className={classes.main_container}>

                <div className={classes.header_container}>
                    <Typography variant="h5" gutterBottom component="div">
                        Rumble
                    </Typography>
                </div>

                <div className={classes.booking_container}></div>

                <div className={classes.image_container}></div>

            </div>
        );
    }
}

export default withStyles(styleSheet)(HomePage)