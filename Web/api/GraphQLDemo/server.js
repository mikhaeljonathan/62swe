import express from 'express';
import { graphqlHTTP } from 'express-graphql';
import { buildSchema } from 'graphql';

// Sample data
let authors = [
  { id: 1, name: 'George Orwell' },
  { id: 2, name: 'Harper Lee' }
];

let books = [
  { id: 1, title: '1984', authorId: 1 },
  { id: 2, title: 'To Kill a Mockingbird', authorId: 2 }
];

// GraphQL schema
const schema = buildSchema(`
  type Author {
    id: ID!
    name: String!
  }

  type Book {
    id: ID!
    title: String!
    author: Author!
  }

  type Query {
    books: [Book]
    book(id: ID!): Book
  }

  type Mutation {
    addBook(title: String!, authorId: ID!): Book
  }
`);

// Resolvers
const root = {
  books: () => {
    return books.map(book => ({
      ...book,
      author: authors.find(author => author.id == book.authorId)
    }));
  },
  book: ({ id }) => {
    const book = books.find(book => book.id == id);
    if (!book) return null;
    return {
      ...book,
      author: authors.find(author => author.id == book.authorId)
    };
  },
  addBook: ({ title, authorId }) => {
    const newBook = { id: books.length + 1, title, authorId: parseInt(authorId) };
    books.push(newBook);
    return {
      ...newBook,
      author: authors.find(author => author.id == newBook.authorId)
    };
  },
  Book: {
    author: (book) => authors.find(author => author.id == book.authorId)
  }
};

const app = express();
app.use('/graphql', graphqlHTTP({
  schema: schema,
  rootValue: root,
  graphiql: true,
}));

app.listen(4000, () => console.log('🚀 Server ready at http://localhost:4000/graphql'));
