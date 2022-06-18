import React, { useState, useEffect } from 'react'
import client from './client'

function App() {
    const [employees, setEmployees] = useState([])

    async function fetchClient() {
        const response = await client({
            method: 'GET',
            path: '/api/employees',
        })
        setEmployees(response.entity._embedded.employees)
    }

    useEffect(() => {
        fetchClient()
    }, [])

    return (
        <Employees employees={employees} />
    )
}

function Employee(props) {
    return (
        <tr>
            <td>{props.employee.firstName}</td>
            <td>{props.employee.lastName}</td>
            <td>{props.employee.description}</td>
        </tr>
    )
}

function Employees(props) {
    const employees = props.employees.map(employee => <Employee key={employee._links.self.href} employee={employee} />)
    return (
        <table>
            <thead>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                {employees}
            </tbody>
        </table>
    )
}

export default App
