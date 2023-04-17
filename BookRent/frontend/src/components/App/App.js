import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Books from "../Books/BookList/Books";
import Categories from "../Categories/Categories";
import BookRentService from "../../repository/bookrentRepository";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: []
        }
    }

    render() {
        return (
            <Router>
                <main>
                    <div className="container">
                        <Route path={"/"} exact render={() =>
                            <Books books={this.state.books}/>}/>
                        <Route path={"/books"} exact render={() =>
                            <Books books={this.state.books}/>}/>
                        <Route path={"/categories"} exact render={() =>
                            <Categories categories={this.state.categories}/>}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadBooks();
    }

    loadBooks = () => {
        BookRentService.fetchBooks()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            })
    }

    loadCategories = () => {
        BookRentService.fetchCategories()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            })
    }

}

export default App;
