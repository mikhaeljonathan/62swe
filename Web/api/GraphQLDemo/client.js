import fetch from 'node-fetch';

const GRAPHQL_URL = 'http://localhost:4000/graphql';

// Helper function to make a GraphQL request
async function graphqlRequest(query, variables = {}) {
  const response = await fetch(GRAPHQL_URL, {
    method: 'POST',
    headers: { 'Content-Type': 'application/json' },
    body: JSON.stringify({
      query,
      variables,
    }),
  });

  const responseBody = await response.json();
  if (responseBody.errors) {
    throw new Error(responseBody.errors.map((error) => error.message).join(', '));
  }

  return responseBody.data;
}

// Define the queries and mutations
const GET_BOOKS = `
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

const GET_BOOK = `
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

const ADD_BOOK = `
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
graphqlRequest(GET_BOOKS)
  .then((data) => console.log(data.books))
  .catch((error) => console.error(error));

// Fetch a single book by ID
graphqlRequest(GET_BOOK, { id: '1' })
  .then((data) => console.log(data.book))
  .catch((error) => console.error(error));

// Add a new book
graphqlRequest(ADD_BOOK, { title: 'Brave New World', authorId: '1' })
  .then((data) => console.log(data.addBook))
  .catch((error) => console.error(error));
