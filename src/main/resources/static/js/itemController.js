const createHTMLList = (title, description, date) =>
    `
    <tr>
        <td>${title}</td>
        <td>${description}</td>
        <td>${date}</td>
    </tr>
`;

class ItemController {

    constructor() {
        this._items = [];
    }

    addItem(title, description, date) {

        var itemController = this;

        const item = {
            title: title,
            description: description,
            date: date
        };

        const formData = new FormData();
        formData.append('title', title);
        formData.append('description', description);
        formData.append('date', date);

        fetch('http://localhost:8080/item/add', {
            method: 'POST',
            body: formData
        })
            .then(response => response.json())
            .then(data => {
                console.log("Add success", data);
                alert("Successfully added to item list")
            })
            .catch(err => {
                console.error("Error:", err);
                alert("Error adding in item into item list")
            });
    }

    displayItem() {

        var itemController = this;
        itemController._items = [];

        fetch('http://127.0.0.1:8080/item/all')
            .then(resp => resp.json())
            .then(data => {
                console.log("Data received");
                console.log(data);
                data.forEach(function (item, index) {
                    const itemObj = {
                        idItem: item.idItem,
                        title: item.title,
                        description: item.description,
                        date: item.date
                    };
                    itemController._items.push(itemObj)
                });
                itemController.render()
            })
            .catch(err => {
                console.error("Error", err)
            })
    }

    render() {
        var itemController = this;
        const itemHTMLList = [];

        for (var i = 0; i < itemController._items.length; i++) {
            const item = itemController._items[i];
            const itemHTML = createHTMLList(item.title, item.description, item.date);
            itemHTMLList.push(itemHTML);
        }

        const iHTML = itemHTMLList.join('\n');
        document.querySelector('#tbody').innerHTML = iHTML;
    }

}