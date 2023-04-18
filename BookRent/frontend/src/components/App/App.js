import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Books from "../Books/BookList/Books";
import Categories from "../Categories/Categories";
import BookRentService from "../../repository/bookrentRepository";
import Header from "../Header/Header";
import BookAdd from "../Books/BookAdd/BookAdd";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: []
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/books/add"} exact render={()=>
                            <BookAdd categories={this.state.categories}
                                    authors={this.state.authors}
                                    onAddBook={this.addBook}/>}/>
                        <Route path={"/books"} exact render={() =>
                            <Books books={this.state.books} onDelete = {this.deleteBook}/>}/>
                        <Route path={"/categories"} exact render={() =>
                            <Categories categories={this.state.categories}/>}/>
                        <Route path={"/"} exact render={() =>
                            <Books books={this.state.books} onDelete = {this.deleteBook}/>}/>
                    </div>
                </main>
            </Router>
        );
    }

    componentDidMount() {
        this.loadBooks();
        this.loadAuthors()
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

    loadAuthors = () => {
        BookRentService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            })
    }

    deleteBook = (id) => {
        BookRentService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            })
    }

    addBook = (name, category, authorId, availableCopies) => {
        BookRentService.addBook(name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            })
    }

}

export default App;
