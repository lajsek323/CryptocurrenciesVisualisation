import logo from './logo.svg';
import './App.css';
import Cards from './components/Cards/Cards'
import Chart from './components/Chart/Chart'
import TickerPicker from './components/TickerPicker/TickerPicker'
import EventPicker from './components/EventPicker/EventPicker'
import DatePickere from './components/DatePicker/DatePicker'
import styles from './App.module.css'
import {fetchData, pickDate} from './api/index'
import "react-datepicker/dist/react-datepicker.css";
import React from 'react';

class App extends React.Component {

  state = {

    data : {},
    data2 : {},
    ticker: 'Ava',
    event: '',
    dateFrom: '2022-03-05',
    dateTo:'2022-04-29',



  }


  async componentDidMount (){
    const datas = await pickDate(this.state.ticker,this.state.dateFrom,this.state.dateTo);
    const datas1 = await fetchData();

    this.setState({data: datas1, data2: datas});
  }

  handleTickerChange = async (ticker, event) =>{
    const fetchedData = await fetchData(ticker, event);
    const pickedData = await pickDate(ticker,this.state.dateFrom,this.state.dateTo);
    console.log(fetchedData);
    console.log(ticker);

    this.setState({data: fetchedData,data2: pickedData, ticker: ticker, event: event})
  }

  handleEventChange = async (ticker, event) =>{
    const fetchedData = await fetchData(ticker,event);
    console.log(fetchedData);
    console.log(event);

    this.setState({data: fetchedData, ticker: ticker, event: event})
  }

  handleDateChange = async (ticker, dateFrom, dateTo) =>{
    const fetchedData = await pickDate(ticker, dateFrom, dateTo);
    console.log(ticker);
    console.log(fetchedData);
    console.log(dateFrom);
    console.log(dateTo);

    this.setState({data2: fetchedData, ticker: ticker, dateFrom: dateFrom, dateTo: dateTo})
  }



  render (){
    const {data, ticker, event,dateFrom, dateTo, data2} = this.state;


  return (
    <div className={styles.container}>
      <Cards data2={data2} dateFrom={dateFrom} dateTo={dateTo} />
      <TickerPicker handleTickerChange ={[this.handleTickerChange, event]}/>
      <br></br>
      <EventPicker handleEventChange ={[this.handleEventChange, ticker]}/>
      <br></br>
      <br></br>
      <Chart data={data} data2={data2} ticker={ticker} event={event}/>
      <br></br>
      <DatePickere handleDateChange={[this.handleDateChange,ticker,dateFrom,dateTo]} />
      <br></br>
      <br></br>
    </div>
  );
}
}

export default App;
