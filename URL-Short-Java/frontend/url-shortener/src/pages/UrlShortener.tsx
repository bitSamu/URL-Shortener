import React, { useEffect, useState } from "react";
import Input from "../components/Input";
import Button from "../components/Button";
import UrlTable from "../components/UrlTable";

const UrlShortener = () => {
  const [userInput, setUserInput] = useState("");

  function handleInputChange(event: React.ChangeEvent<HTMLInputElement>) {
    setUserInput(event.target.value);
  }

  useEffect(() => {
    console.log(userInput);
  }, [userInput]);

  return (
    <>
      <div className="container h-screen flex justify-center items-center">
        <div className="text-center absolute top-1/3">
          <div className="grid grid-cols-6 gap-4">
            <div className="col-start-2 col-span-4 mb-8">
              <h1 className="text-2xl font-medium text-blue-500">
                <span className="text-blue-500">URL Shortener</span>
              </h1>
            </div>
            <div className="col-start-2 col-end-4">
              <Input
                placeholder="Enter a url to shorten"
                handleInputChange={handleInputChange}
              ></Input>
            </div>
            <div className="col-start-4 col-end-6">
              <Button text="Submit"></Button>
            </div>
            <div className="col-start-1 col-end-7 mt-8">
              <UrlTable></UrlTable>
            </div>
          </div>
        </div>
      </div>
    </>
  );
};

export default UrlShortener;
