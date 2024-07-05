const { ApolloClient, InMemoryCache, HttpLink, gql } = require('@apollo/client/core');
const fetch = require('node-fetch');

// Create an Apollo Client
const client = new ApolloClient({
  link: new HttpLink({ uri: 'http://localhost:4000/graphql', fetch }),
  cache: new InMemoryCache()
});

// Define the queries and mutations
const GET_BOOKS = gql`
  query GetBooks {
    books {
      id
      title
      author {
        id
        name
      }
    }
  }
`;

const GET_BOOK = gql`
  query GetBook($id: ID!) {
    book(id: $id) {
      id
      title
      author {
        id
        name
      }
    }
  }
`;

const ADD_BOOK = gql`
  mutation AddBook($title: String!, $authorId: ID!) {
    addBook(title: $title, authorId: $authorId) {
      id
      title
      author {
        id
        name
      }
    }
  }
`;

// Fetch all books
client.query({
  query: GET_BOOKS
})
.then(response => console.log(response.data.books))
.catch(error => console.error(error));

// Fetch a single book by ID
client.query({
  query: GET_BOOK,
  variables: { id: '1' }
})
.then(response => console.log(response.data.book))
.catch(error => console.error(error));

// Add a new book
client.mutate({
  mutation: ADD_BOOK,
  variables: { title: 'Brave New World', authorId: '1' }
})
.then(response => console.log(response.data.addBook))
.catch(error => console.error(error));
