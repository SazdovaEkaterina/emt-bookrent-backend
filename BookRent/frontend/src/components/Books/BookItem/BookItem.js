import React from 'react';

const BookItem = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.book.name}</td>
            <td scope={"col"}>{props.book.category}</td>
            <td scope={"col"}>{props.book.author.name} {props.book.author.surname}</td>
            <td scope={"col"}>{props.book.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => {
                       props.onDelete(props.book.id)
                   }}>Delete</a>
            </td>
        </tr>
    );
}

export default BookItem;
