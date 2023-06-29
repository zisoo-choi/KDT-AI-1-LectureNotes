import { UseQueryResult, useQuery } from 'react-query'
import axiosInst from '../utility/axiosInstance'
import { Board } from '../entity/Board'
import useBoardStore from '../store/BoardStore'

export const fetchBoardList = async (): Promise<Board[]> => {
    const response = await axiosInst.springAxiosInst.get<Board[]>('jpa-board/list')
    return response.data
}

export const useBoardListQuery = (): UseQueryResult<Board[], unknown> => {
    const setBoards = useBoardStore((state)=> state.setBoards) //zustand 매핑

    const queryResult: UseQueryResult<Board[], unknown> = useQuery('boardList', fetchBoardList,{
        onSuccess: (data) =>{
            setBoards(data)
        }
    })

    return queryResult
}