import { render, screen } from '@testing-library/react';
import Dashboard from './Dashboard';

test('renders dashboard', () => {
  render(<Dashboard />);
  const linkElement = screen.getByText(/API Monitor Dashboard/i);
  expect(linkElement).toBeInTheDocument();
});