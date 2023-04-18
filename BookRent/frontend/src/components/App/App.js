import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Books from "../Books/BookList/Books";
import Categories from "../Categories/Categories";
import BookRentService from "../../repository/bookrentRepository";
import Header from "../Header/Header";

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
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/"} exact render={() =>
                            <Books books={this.state.books} onDelete = {this.deleteProduct}/>}/>
                        <Route path={"/books"} exact render={() =>
                            <Books books={this.state.books} onDelete = {this.deleteProduct}/>}/>
                        <Route path={"/categories"} exact render={() =>
                            <Categories categories={this.state.categories}/>}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadBooks();
        //this.loadCategories();
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

    deleteProduct = (id) => {
        BookRentService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

}

export default App;
