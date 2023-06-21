import React, { useState, useEffect } from 'react'
import { useNavigate, useParams } from 'react-router-dom'
import * as axiosClient from "../api/board"
import BoardModifyForm from '../components/BoardModifyForm'

const BoardModifyPage = () => {
    const { boardId } = useParams()
    const [board, setBoard] = useState(null)
    const [isLoading, setLoading] = useState(false)

    const navigate = useNavigate()

    const readBoard = async (boardId) => {
        setLoading(true)

        try {
            const response = await axiosClient.fetchBoard(boardId)
            setBoard(response.data)
            setLoading(false)
        } catch (e) {
            throw e
        }
    }

    const onModify = async (boardId, title, content, writer) => {
        try {
            await axiosClient.modifyBoard(boardId, title, content, writer)
            alert('게시물 수정')
            navigate("/read/" + boardId)
        } catch (e) {
            console.log(e)
        }
    }

    useEffect(() => {
        readBoard(boardId)
    }, [boardId])

    return (
        <BoardModifyForm board={board} isLoading={isLoading} onModify={onModify} />
        // <div>BoardModifyPage</div>
    )

}

export default BoardModifyPage