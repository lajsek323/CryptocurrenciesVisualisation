import axios from 'axios';


const url = 'http://localhost:8080/cryptucurrencies/ava/WarInUkraine'



export const pickDate = async(ticker, dateFrom, dateTo) => {

try {


    let urle = 'http://localhost:8080/';

    const json = JSON.stringify({ ticker: ticker,
    dateFrom: dateFrom,
dateTo: dateTo });
console.log(json)
    const data = await axios.post(urle, json, {headers: {'Content-Type': 'application/json'}});

    console.log(data)
    let tickers = [];
    data.data.map(b => tickers.push(b.ticker))

    let opens = [];
    data.data.map(b => opens.push(b.open))



    let dates = [];
    data.data.map(b => {
        
        var c = b.date.slice(0,10);
        dates.push(c)
    
    })

    let tick = tickers[0];
    let lastOpen = Math.max(...opens);
    let index = opens.indexOf(lastOpen);
    let dateOfMax = dates[index];

     
    return {tickers, opens, dates, tick, lastOpen, dateOfMax};
    
} catch (error) {
    console.log(error);
    
}



}









export const fetchData = async(ticker, event) => {

    let changeableUrl = url;
  
    

    if(ticker){
        changeableUrl = `http://localhost:8080/cryptucurrencies/${ticker}/WarInUkraine`;
       
    }

    if(event){
        changeableUrl = `http://localhost:8080/cryptucurrencies/${ticker}/${event}`;
    }


try {


    const {data} = await axios.get(changeableUrl);

    

   

    
    console.log(data)
    let tickers = [];
    data.map(b => tickers.push(b.ticker))

    let opens = [];
    data.map(b => opens.push(b.open))

    let dates = [];
    data.map(b => {
        
        var c = b.date.slice(0,10);
        dates.push(c)
    
    })


    let tick = tickers[0];
    let lastOpen = Math.max(...opens);
    let index = opens.indexOf(lastOpen);
    let dateOfMax = dates[index];

    
    
    
    
    return {tickers, opens, dates, tick, lastOpen, dateOfMax};

} catch (error) {
    
}


}


export const tickers = async () => {

    try {

        const {response} = await axios.get('http://localhost:8080/cryptucurrencies/tickers');

        console.log(response.data)
        
      

        return {response};
    } catch (error) {
        
    }


}