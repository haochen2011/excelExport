 $worksheet:{
 <Worksheet ss:Name="$it.sheet$">
  <Table ss:ExpandedColumnCount="$it.columnNum$" ss:ExpandedRowCount="$it.rowNum$" x:FullColumns="1"
   x:FullRows="1" ss:DefaultColumnWidth="54" ss:DefaultRowHeight="14.25">
    <Row>
        <Cell><Data ss:Type="String">name1</Data></Cell>
        <Cell><Data ss:Type="String">name2</Data></Cell>
        <Cell><Data ss:Type="String">name3</Data></Cell>
       </Row>
 $it.rows:{
   <Row>
    <Cell><Data ss:Type="String">$it.name1$</Data></Cell>
    <Cell><Data ss:Type="String">$it.name2$</Data></Cell>
    <Cell><Data ss:Type="String">$it.name3$</Data></Cell>
   </Row>
 }$
  </Table>
 </Worksheet>
}$