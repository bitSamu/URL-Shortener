import React from "react";

interface Props {
  text: string;
}

const Button = ({ text }: Props) => {
  return (
    <button className=" bg-blue-500 text-white px-8 py-3 ml-4 rounded-md">
      {text}
    </button>
  );
};

export default Button;
