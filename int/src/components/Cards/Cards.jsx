import React from 'react';
import { Typography, Grid } from '@material-ui/core';
import CardComponent from './Card/Card';
import styles from './Cards.module.css';

const Info = ({ data2,dateFrom, dateTo }) => {
  if (!data2) {
    return 'Loading...';
  }
  console.log(data2.tick);

  return (
    <div className={styles.container}>
        <Typography gutterBottom variant="h4" component="h2">{data2.tick}</Typography>
      <Grid container spacing={3} justify="center">
        <CardComponent
          className={styles.infected}
          cardTitle="Highest price during this period (USD)"
          value={data2.lastOpen}
          cardSubtitle= {`From ${dateFrom} to ${dateTo}`}
        />
        
      </Grid>
    </div>
  );
};

export default Info;