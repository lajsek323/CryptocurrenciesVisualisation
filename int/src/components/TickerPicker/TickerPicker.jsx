import React, {useState, useEffect} from 'react'
import {NativeSelect, FormControl} from '@material-ui/core'
import styles from './TickerPicker.module.css';

import { tickers } from '../../api';


const TickerPicker = ({handleTickerChange}) => {

  const [fetchedTickers = ['Ava','Brava'], setFetchedTickers] = useState([]);


  useEffect(() => {

    
  },[fetchedTickers])


  console.log(fetchedTickers)

  return (
    <><div>Cryptocurrency:</div>
    <br></br>
    <FormControl className={styles.FormControl}>
      <NativeSelect defaultValue="Ava" onChange={(e) => { handleTickerChange[0](e.target.value,handleTickerChange[1]); } }>
        <option value='AVA'>Ava</option>
        <option value='ADA'>ADA</option>
        <option value='BNB'>BNB</option>
        <option value='BTC'>BTC</option>
        <option value='DAI'>DAI</option>
        <option value='DOGE'>DOGE</option>
        <option value='DOT'>DOT</option>
        <option value='ETH'>ETH</option>
        <option value='SOL'>SOL</option>
        <option value='XRP'>XRP</option>
      </NativeSelect>
    </FormControl>
    
    </>


  )
}

export default TickerPicker