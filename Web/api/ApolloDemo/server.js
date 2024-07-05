const express = require('express');
const { ApolloServer, gql } = require('apollo-server-express');

// Sample data
let authors = [
    { id: 1, name: 'George Orwell' },
    { id: 2, name: 'Harper Lee' },
    { id: 3, name: 'Donald Trump' }
];
  
let books = [
    { id: 1, title: '1984', authorId: 1 },
    { id: 2, title: 'To Kill a Mockingbird', authorId: 2 }
];

// GraphQL schema
const typeDefs = gql`
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
`;

// Resolvers
const resolvers = {
    Query: {
      books: () => books,
      book: (_, { id }) => books.find(book => book.id == id)
    },
    Book: {
      author: (parent) => authors.find(author => author.id == parent.authorId)
      // 'parent' here is the 'Book' object that contains the 'authorId'.
    },
    Mutation: {
      addBook: (_, { title, authorId }) => {
        const newBook = { id: books.length + 1, title, authorId: parseInt(authorId) };
        books.push(newBook);
        return newBook;
      }
    }
  };
  

async function startServer() {
    const server = new ApolloServer({ typeDefs, resolvers });
    await server.start();
  
    const app = express();
    server.applyMiddleware({ app });
  
    app.listen({ port: 4000 }, () =>
      console.log(`🚀 Server ready at http://localhost:4000${server.graphqlPath}`)
    );
}
  
startServer();
  