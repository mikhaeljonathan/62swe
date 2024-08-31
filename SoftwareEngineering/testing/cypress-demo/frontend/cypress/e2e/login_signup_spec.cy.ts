describe('Kilogram App E2E Test', () => {
    const backendServer = Cypress.env('VITE_BACKEND_SERVER');

    const correctUsername = 'lia';
    const correctPassword = 'lia';

    const newUsername = '2134';
    const newPassword = 'newpassword';
  
    beforeEach(() => {
      // Clear cookies and local storage before each test
      cy.clearCookies();
      cy.clearLocalStorage();
      cy.wait(500);
    });
  
    it('Should redirect to login if not authenticated', () => {
      cy.visit('/feeds');
      cy.url().should('include', '/login');
    });
  
    it('Should successfully sign up a new user', () => {
      cy.visit('/signup');
  
      cy.get('input[name="username"]').type(newUsername);
      cy.get('input[name="password"]').type(newPassword);
      
      cy.intercept('POST', `${backendServer}/signup`).as('signupRequest');
  
      cy.get('button[type="submit"]').click();
  
      cy.wait('@signupRequest').its('response.statusCode').should('eq', 201);
  
      cy.url().should('include', '/feeds');
    });
  
    it('Should display error message on signup failure', () => {
      cy.visit('/signup');
  
      cy.get('input[name="username"]').type(correctUsername);
      cy.get('input[name="password"]').type(correctPassword);
  
      cy.intercept('POST', `${backendServer}/signup`).as('signupRequest');
  
      cy.get('button[type="submit"]').click();
  
      cy.wait('@signupRequest').its('response.statusCode').should('eq', 400);
  
      cy.get('p.text-red-500').should('be.visible');
    });
  
    it('Should successfully log in an existing user', () => {
      cy.visit('/login');
  
      cy.get('input[name="username"]').type(correctUsername);
      cy.get('input[name="password"]').type(correctPassword);
  
      cy.intercept('POST', `${backendServer}/login`).as('loginRequest');
  
      cy.get('button[type="submit"]').click();
  
      cy.wait('@loginRequest').its('response.statusCode').should('eq', 200);
  
      cy.url().should('include', '/feeds');
    });
  
    it('Should display error message on login failure', () => {
      cy.visit('/login');
  
      cy.get('input[name="username"]').type(correctUsername);
      cy.get('input[name="password"]').type('wrongpassword');
  
      cy.intercept('POST', `${backendServer}/login`).as('loginRequest');
  
      cy.get('button[type="submit"]').click();
  
      cy.wait('@loginRequest').its('response.statusCode').should('eq', 401);
  
      cy.get('p.text-red-500').should('be.visible');
    });

    function authenticate() {
      cy.visit('/login');  
      cy.get('input[name="username"]').type(correctUsername);
      cy.get('input[name="password"]').type(correctPassword);
      cy.get('button[type="submit"]').click();
      cy.intercept('POST', `${backendServer}/login`).as('loginRequest');
      cy.get('button[type="submit"]').click();
      cy.wait('@loginRequest').its('response.statusCode').should('eq', 200);
    }
  
    it('Should display posts in the feed after login', () => {
      authenticate();
  
      cy.intercept('GET', `${backendServer}/posts`).as('postsRequest');
  
      cy.visit('/feeds');
  
      cy.wait('@postsRequest').its('response.statusCode').should('be.oneOf', [200, 304]);
  
      cy.get('div.flex.flex-col.items-center').children().should('have.length.greaterThan', 0);
    });
  
    it('Should toggle like icon on post', () => {
      authenticate();
      
      cy.intercept('GET', `${backendServer}/posts`).as('postsRequest');
  
      cy.visit('/feeds');
  
      cy.wait('@postsRequest');
  
      cy.get('img[src="public/like.svg"]').first().click();
      cy.get('img[src="public/liked.svg"]').first().should('exist');
  
      cy.get('img[src="public/liked.svg"]').first().click();
      cy.get('img[src="public/like.svg"]').first().should('exist');
    });
  });
  