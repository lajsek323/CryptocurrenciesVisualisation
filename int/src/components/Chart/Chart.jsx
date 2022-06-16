import React, {useState, useEffect} from 'react'
import { fetchData, pickDate } from '../../api';
import styles from './Chart.module.css';
import {Line, Bar} from 'react-chartjs-2'
import {Chart as ChartJS, CategoryScale,LinearScale,PointElement,LineElement,Title,Tooltip,Legend, } from 'chart.js';
ChartJS.register(CategoryScale,LinearScale,PointElement,
LineElement,Title,Tooltip,Legend);



const  Chart = ({data,data2, ticker}) =>  {

  const [fetchedData, setFetchedData] = useState([]);
  const [pickedData, setPickedData] = useState([]);


  useEffect(() => {
    const fetchWar = async() => {
      
      setFetchedData( await fetchData(ticker));
     
    }
    
   

      fetchWar();
      
  },[]);

  console.log(fetchedData);
  console.log(ticker);
  console.log(data);
  const lineChart = (
  
    <Line 
      data={{
labels: data.dates,
datasets: [{
  data: data.opens,
  label: data.tick,
  backgroundColor: 'gray',
  borderColor: 'blue',
  fill:true,
}],

      }}


    />

  );

  const lineChart2 = (
  
    <Line 
      data={{
labels: data2.dates,
datasets: [{
  data: data2.opens,
  label: data2.tick,
  backgroundColor: 'cyan',
  borderColor: 'green',
  fill:true,
}],

      }}


    />

  );


  return (
    <><div className={styles.container}>
      {lineChart}
    </div>
     <br></br><br></br><br></br><br></br>
    <div className={styles.container}>
     
        {lineChart2}
      </div></>

    


  )
}

export default Chart