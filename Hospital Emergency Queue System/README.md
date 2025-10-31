🏥 Hospital Emergency Queue System (Doubly Linked List)
📘 Project Overview

This project simulates a Hospital Emergency Room (ER) Queue System using a Doubly Linked List in C++.
It helps manage patients based on priority — allowing critical patients to be treated first and others to wait in order.
The system provides efficient insertion and deletion of patients from any position in the list.

🎯 Features / Operations

insertAtBeginning(patientID) – Adds a critical patient to the start of the list.

insertAtEnd(patientID) – Adds a normal walk-in patient to the end of the list.

insertAtPosition(patientID, position) – Inserts a patient at a specific priority position.

deleteFromBeginning() – Removes the first patient after treatment.

⚙️ Data Structure Used

Doubly Linked List

Each node contains:

patientID (integer)

prev pointer (to previous patient)

next pointer (to next patient)

🧩 Dry Run / Example Steps

Starting with an empty ER list, the following operations are performed:

insertAtEnd(101)

insertAtEnd(102)

insertAtBeginning(200) → Critical patient

insertAtPosition(150, 2)

deleteFromBeginning()

insertAtEnd(300)

Final Output:

Head: 150

Tail: 300

Forward Traversal: 150 → 101 → 102 → 300

Backward Traversal: 300 → 102 → 101 → 150

🧠 Working Methodology

Start with an empty ER list.

Insert patients based on their urgency level.

Update all head, tail, prev, and next pointers after each operation.

Remove patients after treatment.

Maintain the correct order dynamically in real time.

💻 Technologies Used

Language: C++

Data Structure: Doubly Linked List



📚 Conclusion

This project successfully demonstrates how a Doubly Linked List can be used to manage real-world priority queues like hospital ER systems.
It ensures that critical patients are treated first and the queue dynamically updates as patients are added or removed.

👨‍💻 Author
Name: Ishtiaq Ahmemd
