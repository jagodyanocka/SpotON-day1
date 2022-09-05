function fetchData() {
    const params = (new URL(document.location)).searchParams;
    const name = params.get("name");
    const search = name?`?name=${name}` : '';
    const star = document.querySelector('#salt-star');
    fetch(`http://localhost:8100?${search}`, {mode: 'cors'})
    .then((response) =>  response.json() )
    .then( json => {
        star.textContent = JSON.stringify(json.name);
    })
    .catch(err =>  {
        console.log(err);
        star.textContent = '${err}';
      });
  }
  
fetchData();
  