// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract StudentManagement {
    struct Student {
        uint id;
        string name;
        uint age;
    }

    Student[] public students;
    uint public studentCount;

    mapping(uint => bool) private idExists;

    event StudentAdded(uint id, string name, uint age);

    constructor() {
        studentCount = 0;
    }

    function addStudent(uint _id, string memory _name, uint _age) public {
        require(!idExists[_id], "Student ID already exists");

        students.push(Student(_id, _name, _age));
        idExists[_id] = true;
        studentCount++;

        emit StudentAdded(_id, _name, _age);
    }

    function getStudent(uint index) public view returns (uint, string memory, uint) {
        require(index < students.length, "Index out of bounds");
        Student memory student = students[index];
        return (student.id, student.name, student.age);
    }

    fallback() external payable {
    }

    function getContractBalance() public view returns (uint) {
        return address(this).balance;
    }
}
