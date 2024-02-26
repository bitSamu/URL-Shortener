import React, { useState } from "react";
import Input from "../components/Input";
import Button from "../components/Button";

const UrlShortener = () => {
  const [userInput, setUserInput] = useState("");

  return (
    <div className=" container h-screen flex justify-center items-center">
      <div className=" text-center">
        <h1 className=" text-2xl font-medium text-blue-500 mb-4">
          <span className=" text-blue-500">URL Shortener</span>
        </h1>
        <div>
          <Input placeholder="Enter a url to shorten"></Input>
          <Button text="Submit"></Button>
        </div>
      </div>
    </div>
  );

  function handleUserInput(userInput: string) {
    setUserInput(userInput);
  }
};

export default UrlShortener;
