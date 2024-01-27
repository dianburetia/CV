// DataChart.js
import React, { useEffect, useState,useRef } from 'react';
import axios from 'axios';
import { Bar } from 'react-chartjs-2';
import Chart from 'chart.js/auto'; // Import Chart from chart.js library
import 'chartjs-adapter-date-fns';
const LiveBarChart = () => {
    const [data, setData] = useState([]);
    const chartRef = useRef(null);
  
    useEffect(() => {
      const fetchData = async () => {
        try {
          const response = await axios.get('http://localhost:8083/api/data/values');
          setData(response.data);
          console.log('Fetched data:', response.data);
        } catch (error) {
          console.error('Error fetching data:', error);
        }
      };
  
      // Fetch data initially
      fetchData();
  
      // Set up a timer to fetch data every 5 seconds (adjust as needed)
      const timer = setInterval(fetchData, 5000);
  
      // Clean up the timer and the Chart instance on component unmount
      return () => {
        clearInterval(timer);
        destroyChart();
      };
    }, []);
  
    useEffect(() => {
        // Cleanup the previous Chart instance before rendering a new one
        destroyChart();
      
        // Get the current date
        const currentDate = new Date();
      
        // Filter the data for the current day
        const todayData = data.filter((_, index) => {
          const dataDate = new Date(`2023-12-07T${index + 1}:00:00Z`);
          return dataDate.getDate() === currentDate.getDate();
        });
      
        // Map values for each hour of the day
        const mappedData = Array.from({ length: 24 }, (_, index) => {
          const hourData = todayData.find((_, dataIndex) => {
            const dataDate = new Date(`2023-12-07T${dataIndex + 1}:00:00Z`);
            return dataDate.getHours() === index;
          });
      
          return hourData !== undefined ? hourData : 0; // Replace 0 with a default value if no data is found
        });
      
        // Create a new Chart instance
        const ctx = document.getElementById('myChart').getContext('2d');
        chartRef.current = new Chart(ctx, {
          type: 'bar',
          data: {
            labels: Array.from({ length: data.length }, (_, index) => index + 1),
            datasets: [
              {
                label: 'Database Values',
                backgroundColor: 'rgba(75, 192, 192, 0.2)',
                borderColor: 'rgba(75, 192, 192, 1)',
                borderWidth: 1,
                data: mappedData,
              },
            ],
          },
          options: {
            scales: {
              x: {
                type: 'time',
                time: {
                  unit: 'hour',
                  displayFormats: {
                    hour: 'HH:00',
                  },
                  minUnit: 'hour',
                },
                title: {
                  display: true,
                  text: 'Hour of the Day',
                },
                ticks: {
                  stepSize: 10,
                },
              },
              y: {
                title: {
                  display: true,
                  text: 'Database Values',
                },
              },
            },
          },
        });
      }, [data]);
  
    const destroyChart = () => {
      // Cleanup the Chart instance
      if (chartRef.current) {
        chartRef.current.destroy();
        chartRef.current = null;
      }
    };
  
    return (
      <div>
        <h1>Live Updating Bar Chart</h1>
        <canvas id="myChart" width="400" height="200"></canvas>
      </div>
    );
  };
  
  export default LiveBarChart;