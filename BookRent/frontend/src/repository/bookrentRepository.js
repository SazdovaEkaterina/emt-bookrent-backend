import axios from '../custom-axios/axios';

const BookRentService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },
    deleteBook: (id) => {
        return axios.delete(`/books/${id}/delete`);
    }
}

export default BookRentService;