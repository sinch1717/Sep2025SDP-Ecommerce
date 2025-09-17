1. Find user who placed multiple orders
    ```bash
        db.orders.aggregate([
        {
            $group: {
            _id: "$userId",          // group by userId
            orderCount: { $sum: 1 }, // count orders
            orders: { $push: "$_id"} // collect order ids if needed
            }
        },
        {
            $match: {
            orderCount: { $gt: 1 }   // only keep users with more than 1 order
            }
        }
        ])

     ```