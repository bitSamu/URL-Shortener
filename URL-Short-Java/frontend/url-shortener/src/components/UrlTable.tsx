import React, { useState } from "react";

export type URLEntry = {
  originalUrl: string;
  shortendUrl: string;
  clicks: number;
};

const UrlTable = () => {
  const [urlEntries, setUrlEntries] = useState<URLEntry[]>([]);
  const titles = ["Original URL", "Shortened URL", "Clicks"];
  const titleListItems = titles.map((title) => (
    <th
      scope="col"
      className="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider"
      key={title}
    >
      {title}
    </th>
  ));

  const addNewUrlEntry = () => {};

  const urlEntriesListItems = urlEntries.map((urlEntry) => (
    <tr key={urlEntry.originalUrl}>
      <td className="px-6 py-4 whitespace-nowrap">{urlEntry.originalUrl}</td>
      <td className="px-6 py-4 whitespace-nowrap">{urlEntry.shortendUrl}</td>
      <td className="px-6 py-4 whitespace-nowrap">{urlEntry.clicks}</td>
    </tr>
  ));

  return (
    <>
      <table className="min-w-full divide-y divide-gray-200">
        <thead className="bg-gray-50">
          <tr>{titleListItems}</tr>
        </thead>
        <tbody className="bg-white divide-y divide-gray-200">
          {urlEntriesListItems}
        </tbody>
      </table>
    </>
  );
};

export default UrlTable;
