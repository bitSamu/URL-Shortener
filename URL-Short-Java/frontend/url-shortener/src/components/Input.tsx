import React from "react";

interface Props {
  placeholder: string;
  handleInputChange: () => void;
}

const Input: React.FC<Props> = ({ placeholder, handleInputChange }) => {
  return (
    <input
      className="outline-none border-2 border-blue-500 rounded-md backdrop-blur-xl bg-white/20 shadow-md px-3 py-3"
      type="text"
      placeholder={placeholder}
      onChange={handleInputChange}
    />
  );
};

export default Input;
