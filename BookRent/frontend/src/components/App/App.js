import './App.css';
import React, {Component} from "react";
import {BrowserRouter as Router, Redirect, Route} from 'react-router-dom'
import Books from "../Books/BookList/Books";
import Categories from "../Categories/Categories";
import BookRentService from "../../repository/BookRentRepository";
import Header from "../Header/Header";
import BookAdd from "../Books/BookAdd/BookAdd";
import BookEdit from "../Books/BookEdit/BookEdit";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {
            books: [],
            categories: [],
            authors: [],
            selectedBook: {}
        }
    }

    render() {
        return (
            <Router>
                <Header/>
                <main>
                    <div className="container">
                        <Route path={"/books/:id/edit"} exact render={() =>
                            <BookEdit categories={this.state.categories}
                                      authors={this.state.authors}
                                      onEditBook={this.editBook}
                                      book={this.state.selectedBook}/>}/>
                        <Route path={"/books/add"} exact render={() =>
                            <BookAdd categories={this.state.categories}
                                     authors={this.state.authors}
                                     onAddBook={this.addBook}/>}/>
                        <Route path={"/books"} exact render={() =>
                            <Books books={this.state.books}
                                   onDelete={this.deleteBook}
                                   onEdit={this.getBook}
                                   onMarkAsTaken={this.markBookAsTaken}/>}/>
                        <Route path={"/categories"} exact render={() =>
                            <Categories categories={this.state.categories}/>}/>
                        <Route path={"/"} exact render={() =>
                            <Books books={this.state.books}
                                   onDelete={this.deleteBook}
                                   onEdit={this.getBook}
                                   onMarkAsTaken={this.markBookAsTaken}/>}/>
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
            });
    }

    loadCategories = () => {
        BookRentService.fetchCategories()
            .then((data) => {
                this.setState({
                    books: data.data
                })
            });
    }

    loadAuthors = () => {
        BookRentService.fetchAuthors()
            .then((data) => {
                this.setState({
                    authors: data.data
                })
            });
    }

    deleteBook = (id) => {
        BookRentService.deleteBook(id)
            .then(() => {
                this.loadBooks();
            });
    }

    addBook = (name, category, authorId, availableCopies) => {
        BookRentService.addBook(name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    getBook = (id) => {
        BookRentService.getBook(id)
            .then((data) => {
                this.setState({
                    selectedBook: data.data
                })
            });
    }

    editBook = (id, name, category, authorId, availableCopies) => {
        BookRentService.editBook(id, name, category, authorId, availableCopies)
            .then(() => {
                this.loadBooks();
            });
    }

    markBookAsTaken = (id) => {
        BookRentService.markBookAsTaken(id)
            .then(() => {
                this.loadBooks();
            });
    }

}

export default App;
