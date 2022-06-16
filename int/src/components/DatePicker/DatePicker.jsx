import React, { Fragment} from "react";


const DatePickere = ({handleDateChange}) => {

    


  return (
   
    <div>
      <input type="date" value={handleDateChange[2]} onChange={(e) => {handleDateChange[0](handleDateChange[1],e.target.value,handleDateChange[3])}}  />
      <input type="date" value={handleDateChange[3]} onChange={(e) => {handleDateChange[0](handleDateChange[1],handleDateChange[2],e.target.value)}}  />
    </div>

  );
}

export default DatePickere;

