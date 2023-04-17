import axios from '../custom-axios/axios';

const BookRentService = {
    fetchBooks: () => {
        return axios.get("/books");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    }
}

export default BookRentService;