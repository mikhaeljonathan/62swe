// import React from 'react';
import { render, screen } from '@testing-library/react';
import NavBar from '../src/navbar/Navbar';

test('renders the NavBar with all links', () => {
  render(<NavBar />);

  // Check for the "Kilogram" brand text
  const brandElement = screen.getByText(/kilogram/i);
  expect(brandElement).toBeInTheDocument();

  // Check for the "About" link
  const aboutLink = screen.getByRole('link', { name: /about/i });
  expect(aboutLink).toBeInTheDocument();

  // Check for the "Edit profile" link
  const editProfileLink = screen.getByRole('link', { name: /edit profile/i });
  expect(editProfileLink).toBeInTheDocument();

  // Check for the "Log out" link
  const logoutLink = screen.getByRole('link', { name: /log out/i });
  expect(logoutLink).toBeInTheDocument();
});
