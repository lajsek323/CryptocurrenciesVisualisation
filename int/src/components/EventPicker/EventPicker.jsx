import React, {useState, useEffect} from 'react'
import {NativeSelect, FormControl} from '@material-ui/core'
import styles from './EventPicker.module.css';



const EventPicker = ({handleEventChange}) => {

 

  return (
    <><div>Events:</div>
    <FormControl className={styles.FormControl}>
      <NativeSelect defaultValue="WarInUkraine" onChange={(e) => { handleEventChange[0](handleEventChange[1],e.target.value); } }>
        <option value='WarInUkraine'>War in Ukraine</option>
        <option value='Event2'>Chinese government blocks cryptocurrencies</option>
        <option value='Pandemic'>The beginning of a pandemic</option>
        
      </NativeSelect>
    </FormControl></>
  )
}

export default EventPicker