import React, { Component } from 'react';
import { Link } from "react-router-dom";
import axios from 'axios'

class AddTask extends Component{
    constructor(){
        super();
        this.state={
            age:0,
            firstname:"",
            lastname:"",
            password:"",
            username:""
        };
        this.onChange = this.onChange.bind(this);
        this.onSubmit = this.onSubmit.bind(this);
    }
    onChange(e){
        this.setState({[e.target.name]:e.target.value})
    }
    /*componentDidMount(){
        this.submit();
    }*/
     async onSubmit(e){
        e.preventDefault();
        const taskBoard = {
            age : this.state.age,
            firstname : this.state.firstname,
            lastname : this.state.lastname,
            password : this.state.password,
            username : this.state.username,
        };
     console.log(taskBoard);
        axios.post('http://localhost:8080/entry/board', taskBoard)
      .then(res => {
        console.log(res);
        console.log(res.data);
      }).catch(error => {
        console.log(error.res);
      });
        console.log(taskBoard);
        this.props.history.push('/');
}
    render(){
  return (
<div class="addProjectTask">
        <div class="container">
            <div class="row">
                <div class="col-md-8 m-auto">
                    <Link to="/" className="btn btn-info mb-3">
                    <i className="fas fa-plus-circle"> Back To DashBoard</i>
                    </Link>
                    <h4 class="display-4 text-center">Add /Update Project Task</h4>
                    <form onSubmit={this.onSubmit}>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="age" value ={this.state.age} onChange={this.onChange} placeholder="Age" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="firstname" value ={this.state.firstname} onChange={this.onChange} placeholder="Firstname" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="lastname" value ={this.state.lastname} onChange={this.onChange} placeholder="Lastname" />
                        </div>
                        <div class="form-group">
                            <input type="password" class="form-control form-control-lg" name="password" value ={this.state.password} onChange={this.onChange} placeholder="Password" />
                        </div>
                        <div class="form-group">
                            <input type="text" class="form-control form-control-lg" name="username" value ={this.state.username} onChange={this.onChange} placeholder="Username" />
                        </div>
                        <input type="submit" onClick={<Link to="/"></Link>} class="btn btn-primary btn-block mt-4" />
                    </form>
                </div>
            </div>
        </div>
    </div>
  );
    }
}
export default AddTask;