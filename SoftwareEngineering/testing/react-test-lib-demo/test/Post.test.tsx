import { render, screen, fireEvent } from '@testing-library/react';
import Post from '../src/main/Post';

const mockPost = {
  username: 'testuser',
  imageurl: 'http://example.com/image.jpg',
  likes: 10,
};

test('renders the Post component with like functionality', () => {
  render(<Post post={mockPost} />);

  // Check for the username
  const usernameElement = screen.getByText(/testuser/i);
  expect(usernameElement).toBeInTheDocument();

  // Check for the likes count
  const likesElement = screen.getByText(/10/i);
  expect(likesElement).toBeInTheDocument();

  // Check for the images (post and like)
  const imageElements = screen.getAllByRole('img');
  expect(imageElements).toHaveLength(2); // Expecting two images

  // Check for the post image
  const postImage = imageElements[0];
  expect(postImage).toHaveAttribute('src', 'http://example.com/image.jpg');

  // Check the initial like icon  
  const likeIcon = imageElements[1];
  expect(likeIcon).toHaveAttribute('src', 'public/like.svg');

  // Click the like icon
  fireEvent.click(likeIcon);

  // Check the toggled like icon
  expect(likeIcon).toHaveAttribute('src', 'public/liked.svg');
});
